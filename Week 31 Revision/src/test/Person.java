package test;

public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		
	}
	
	
	public Person(String name, int age) {
		this.setName(name);;
		this.setAge(age);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.equals("")) {
			throw new NullPointerException("empty string");
		} else {
			this.name = name;
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

}
