package entity;

public class Android {
	private String id,name,homework,video;

	public Android(String id, String name, String homework, String video) {
		super();
		this.id = id;
		this.name = name;
		this.homework = homework;
		this.video = video;
	}

	public Android() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}
