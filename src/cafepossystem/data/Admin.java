package cafepossystem.data;

public class Admin {

	private String seq;
	private String name;
	private String status;
	private String password;
	
	public Admin(String seq, String name, String status, String password) {
		super();
		this.seq = seq;
		this.name = name;
		this.status = status;
		this.password = password;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
