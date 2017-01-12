package day2.jdbctemplate;

public class Students {
	
	
	private Long id;
	private String name;
	private String age;

	
    public Students() {};
	public Students(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", age=" + age + "]";
	}


	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}



	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
