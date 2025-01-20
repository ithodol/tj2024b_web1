package day03.task4;

public class WaitingDto {
	private String tel;
	private int count;
	private int num;
	
	public WaitingDto() {}

	public WaitingDto(String tel, int count, int num) {
		super();
		this.tel = tel;
		this.count = count;
		this.num = num;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "WaitingDto [tel=" + tel + ", count=" + count + ", num=" + num + "]";
	}
	
	
	
}
