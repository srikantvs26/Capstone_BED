package com.wipro.diet.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.diet.app.beans.AboveMsgs;
import com.wipro.diet.app.beans.BelowMsgs;
import com.wipro.diet.app.beans.Chats;
import com.wipro.diet.app.beans.DailyLogs;
import com.wipro.diet.app.beans.GroupFiles;
import com.wipro.diet.app.beans.MonthlyMeasurements;
import com.wipro.diet.app.beans.NewUser;
import com.wipro.diet.app.beans.User;
import com.wipro.diet.app.repos.AboveMsgsRepository;
import com.wipro.diet.app.repos.BelowMsgsRepository;
import com.wipro.diet.app.repos.ChatsRepository;
import com.wipro.diet.app.repos.DailyLogsRepository;
import com.wipro.diet.app.repos.GroupFilesRepository;
import com.wipro.diet.app.repos.MonthlyMeasureRepository;
import com.wipro.diet.app.repos.NewUserRepository;
import com.wipro.diet.app.repos.UserRepository;


@RestController
@CrossOrigin(origins = "https://capstone-bed.herokuapp.com")
public class ControllerDiet {
	@Autowired
	private UserRepository userR;
	@Autowired
	private NewUserRepository newUserR;
	@Autowired
	private AboveMsgsRepository aboveMsgs;
	@Autowired
	private BelowMsgsRepository belowMsgs;
	@Autowired
	private ChatsRepository chatsR;
	@Autowired
	private GroupFilesRepository groupFilesR;
	@Autowired
	private DailyLogsRepository dailyFilesR;
	@Autowired
	private MonthlyMeasureRepository monthlyFilesR;



	String username, emailId, fname;
	int group = 25;

	
	@GetMapping("/")
	public String status() {
		return "index";
	}
	

	
	@GetMapping("/login/{email}/{pass}")
	public int loginEnter(@PathVariable("email") String email, @PathVariable("pass") String pass) {
		User u = userR.findByUserId(email);
		if (u == null) {

			return -1;
		} else if ((u.getUserId().equals(email)) && (u.getPassword().equals(pass))) {
			username = u.getFname();
			emailId = u.getEmail();
			fname = u.getFname();
			group = userR.findDivision(emailId);
			if (u.getType().equals("user") || u.getType().equals("motivator")) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return 0;
		}
	}

	@PostMapping("/signup")
	public boolean signup(@RequestBody NewUser user) {
		
		System.out.println("----------------");
		System.out.println(user);
		newUserR.save(user); // initially we only save in the new newuser Repo. 
							//once the admin accepts the request then we push the details into the user Repo
							//please note here the repos newuserrepo and userrepo.
		System.out.println("----------------");
		return true;
	}

	@GetMapping("/requests")
	public ArrayList<NewUser> getrequests() {
		String s = "pending";
		ArrayList<NewUser> r = newUserR.findByStatus(s);
		return r;
	}

	@PostMapping("/approved")
	public boolean approved(@RequestBody NewUser user) {

		newUserR.setStatusForNewUser("approved", user.getEmail());
		//String[] arr = user.getEmail().split("@");
		//String id = arr[0];
		//String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		//StringBuilder pass = new StringBuilder();
		//Random rnd = new Random();
		//while (pass.length() < 10) {
		//	int index = (int) (rnd.nextFloat() * alpha.length());
		//	pass.append(alpha.charAt(index));
		//}
		//String password = pass.toString();
		float bmi = user.getWeight() / (user.getHeight() * (user.getHeight()));
		int div;
		if (bmi > 25) {
			div = 26;
		} else {
			div = 24;
		}
		
	
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(System.currentTimeMillis());
		User u = new User(user.getUserid(), user.getFname(), user.getLname(), user.getEmail(), user.getPassword(), "user", div, df.format(d));


		userR.save(u);
		
		MonthlyMeasurements m = new MonthlyMeasurements(user.getFname(), user.getEmail(), "null", "null", "null", div);
		monthlyFilesR.save(m);
		String divis;
		if (div > 26)
			divis = "Above BMI25";
		else
			divis = "Below BMI25";

		return true;
	}

	@PostMapping("/rejected")
	public boolean rejected(@RequestBody NewUser user) {
		newUserR.deleteById(user.getEmail());
		return true;
	}

	@GetMapping("/details/{email}")
	public NewUser details(@PathVariable("email") String email) {
		return newUserR.findByEmail(email);
	}

	@GetMapping("/abovemsgs")
	public ArrayList<AboveMsgs> getAboveMsgs() {
		group = 26;
		ArrayList<AboveMsgs> r = aboveMsgs.findById();
		return r;
	}

	@PostMapping("/savingmsg")
	public boolean savingmsg(@RequestBody AboveMsgs msg) {
		aboveMsgs.save(new AboveMsgs(username, msg.getMsg(), msg.getTime(), msg.getAccess()));
		return true;
	}

	@PostMapping("/deletingabovemsg")
	public boolean deleteAboveMsg(@RequestBody AboveMsgs msg) {
		aboveMsgs.deleteById(msg.getSlno());
		return true;
	}

	@GetMapping("/belowmsgs")
	public ArrayList<BelowMsgs> getBelowMsgs() {
		group = 24;
		ArrayList<BelowMsgs> r = belowMsgs.findById();
		return r;
	}

	@PostMapping("/savinbelowgmsg")
	public boolean savinbelowgmsg(@RequestBody BelowMsgs msg) {
		belowMsgs.save(new BelowMsgs(username, msg.getMsg(), msg.getTime(), msg.getAccess()));
		return true;
	}

	@PostMapping("/deletingbelowmsg")
	public boolean deleteBelowMsg(@RequestBody BelowMsgs msg) {
		belowMsgs.deleteById(msg.getSlno());
		return true;
	}

	@GetMapping("/getaccess")
	public boolean getaccess() {
		if ((userR.findByFname(username)).getType().equals("motivator"))
			return true;
		else
			return false;
	}

	@GetMapping("/getdiv")
	public int getdiv() {
		return (userR.findByFname(username)).getDivision();
	}

	@GetMapping("/getusers")
	public ArrayList<User> getUsers() {
		return userR.findByEmail("admin");
	}

	@GetMapping("/getusersbyid/{div}")
	public ArrayList<User> getUsersById(@PathVariable("div") int div) {
		return userR.findByDiv(div);
	}

	@GetMapping("/settype/{email}/{type}")
	public boolean settype(@PathVariable("email") String email, @PathVariable("type") String type) {
		userR.settype(type, email);
		return true;
	}

	@GetMapping("/deleteuser/{email}")
	public boolean deleteUser(@PathVariable("email") String email) {
		newUserR.deleteUser(email);
		userR.deleteUser(email);
		monthlyFilesR.deleteUser(email);

		return true;
	}

	@GetMapping("/chattimeline/{from}/{to}")
	public ArrayList<Chats> getIndividualMsgs(@PathVariable("from") String from, @PathVariable("to") String to) {
		return chatsR.findByTmail(from, to);
	}

	@PostMapping("/savingchat")
	public boolean savingchat(@RequestBody Chats chat) {
		chatsR.save(new Chats(chat.getTime(), username, chat.getFmail(), userR.findFname(chat.getTmail()),
				chat.getTmail(), chat.getMsg()));
		return true;
	}

	@GetMapping("/getallusers")
	public ArrayList<User> getAllUsers() {
		return userR.findAllUsers(emailId);
	}

	@GetMapping("/getindividualmsgs")
	public ArrayList<Chats> getIndividualMsgs() {
		return chatsR.findByTmail(emailId);
	}

	@GetMapping("/getemailid")
	public User getEmailId() {
		return userR.findByFname(fname);
	}

	@GetMapping("/newchat/{email}/{msg}")
	public boolean newChat(@PathVariable("email") String email, @PathVariable("msg") String msg) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(System.currentTimeMillis());
		Chats c = new Chats(df.format(d), userR.findFname(emailId), emailId, userR.findFname(email), email, msg);
		chatsR.save(c);
		Chats e = new Chats(df.format(d), userR.findFname(email), email, userR.findFname(emailId), emailId, null);
		chatsR.save(e);
		return true;
	}

	// Files
	@PostMapping("/uploadfile")
	public String uploadAbovetFile(@RequestBody MultipartFile file) {
		try {
			GroupFiles filetostore = new GroupFiles(file.getOriginalFilename(), file.getContentType(), file.getBytes(),
					group);
			groupFilesR.save(filetostore);
			return "File uploaded successfully!";
		} catch (Exception e) {
			return "FAIL!";
		}
	}

	@GetMapping("/allabovefiles")
	public List<GroupFiles> getAboveFiles() {
		return groupFilesR.findByZone(26);
	}

	@GetMapping("/allbelowfiles")
	public List<GroupFiles> getBelowFiles() {
		return groupFilesR.findByZone(24);
	}

	@GetMapping("/deletefile/{id}")
	public void deleteAboveFile(@PathVariable Long id) {
		groupFilesR.deleteById(id);
	}

	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getAboveFile(@PathVariable("id") Long id) {
		Optional<GroupFiles> fileOptional = groupFilesR.findById(id);

		if (fileOptional.isPresent()) {
			GroupFiles file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.contentType(MediaType.parseMediaType(file.getMimetype())).body(file.getPic());
		}
		return ResponseEntity.status(404).body(null);
	}

	@PostMapping("/uploadDailyfile")
	public String uploadDailyFile(@RequestBody MultipartFile file) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date d = new Date(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000);
			DailyLogs filetostore = new DailyLogs(df.format(d), fname, emailId, file.getOriginalFilename(),
					file.getContentType(), file.getBytes(), group);
			dailyFilesR.save(filetostore);
			return "File uploaded successfully!";
		} catch (Exception e) {
			return "FAIL!";
		}
	}

	@GetMapping("/getuploadpermission")
	public boolean getUploadPermission() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000);
		if (dailyFilesR.findByLastUpload(emailId, df.format(d)) == 1) {
			return false;
		} else {
			return true;
		}
	}

	@GetMapping("/abovedailyfiles")
	public List<DailyLogs> getAboveDailyFiles() {
		return dailyFilesR.findByZone(26);
	}

	@GetMapping("/belowdailyfiles")
	public List<DailyLogs> getBelowDailyFiles() {
		return dailyFilesR.findByZone(24);
	}

	@GetMapping("/dailyfile/{id}")
	public ResponseEntity<byte[]> getDailyFile(@PathVariable("id") Long id) {
		Optional<DailyLogs> fileOptional = dailyFilesR.findById(id);
		if (fileOptional.isPresent()) {
			DailyLogs file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.contentType(MediaType.parseMediaType(file.getMimetype())).body(file.getPic());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/uploadhistory/{email}")
	public List<DailyLogs> uploadHistory(@PathVariable("email") String email) {
		return dailyFilesR.findByEmail(email);
	}

	@GetMapping("/getmonthlystatus")
	public int[] getMonthlyStatus() {
		int[] a = new int[3];
		String m = monthlyFilesR.findFileNames(emailId);
		String[] month = m.split(",");

		if (month[0].equals("null"))
			a[0] = 0;
		else
			a[0] = 1;
		if (month[1].equals("null"))
			a[1] = 0;
		else
			a[1] = 1;
		if (month[2].equals("null"))
			a[2] = 0;
		else
			a[2] = 1;
		return a;
	}

	@GetMapping("/enrolleligibility/{m}")
	public boolean sendEnrollEligibility(@PathVariable int m) {
		String doj = userR.findDoj(emailId);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(System.currentTimeMillis());
		String currentDate = myFormat.format(d);
		float daysBetween;
		try {
			Date dateBefore = myFormat.parse(doj);
			Date dateAfter = myFormat.parse(currentDate);
			long difference = dateAfter.getTime() - dateBefore.getTime();
			daysBetween = (difference / (1000 * 60 * 60 * 24));
			if (m == 1)
				if ((int) daysBetween > 30)
					return true;
				else
					return false;
			else if (m == 2)
				if ((int) daysBetween > 60)
					return true;
				else
					return false;
			else if ((int) daysBetween > 90)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	@PostMapping("/uploadmonthlyfile/{month}")
	public String uploadMonthlyFile(@RequestBody MultipartFile file, @PathVariable int month) {
		try {
			if (month == 1) {
				monthlyFilesR.uploadFirstFile(file.getOriginalFilename(), file.getBytes(), file.getContentType(),
						emailId);
			} else if (month == 2) {
				monthlyFilesR.uploadSecondFile(file.getOriginalFilename(), file.getBytes(), file.getContentType(),
						emailId);
			} else {
				monthlyFilesR.uploadThirdFile(file.getOriginalFilename(), file.getBytes(), file.getContentType(),
						emailId);
			}
			return "File uploaded successfully";
		} catch (Exception e) {
			return "FAIL!";
		}
	}

	@GetMapping("/abovemonthlyfiles")
	public List<MonthlyMeasurements> getAboveMonthlyFiles() {
		return monthlyFilesR.findByZone(26);
	}

	@GetMapping("/belowmonthlyfiles")
	public List<MonthlyMeasurements> getBelowMonthlyFiles() {
		return monthlyFilesR.findByZone(24);
	}

	@GetMapping("/monthlyfile/{filename}/{email}")
	public ResponseEntity<byte[]> getMonthlyFile(@PathVariable("filename") int id,
			@PathVariable("email") String email) {
		Optional<MonthlyMeasurements> fileOptional = monthlyFilesR.findFile(email);
		if (fileOptional.isPresent()) {
			MonthlyMeasurements file = fileOptional.get();
			if (id == 1) {
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + file.getNameFirstF() + "\"")
						.contentType(MediaType.parseMediaType(file.getMimetypeF())).body(file.getFileFirst());
			} else if (id == 2) {
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + file.getNameSecondF() + "\"")
						.contentType(MediaType.parseMediaType(file.getMimetypeS())).body(file.getFileSecond());
			} else {
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + file.getNameThirdF() + "\"")
						.contentType(MediaType.parseMediaType(file.getMimetypeT())).body(file.getFileThird());
			}

		}
		return ResponseEntity.status(404).body(null);
	}

}
