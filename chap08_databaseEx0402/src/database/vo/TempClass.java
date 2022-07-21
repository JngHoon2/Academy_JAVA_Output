package database.vo;

public class TempClass {
	private String job;
	private int count;
	private int sum;
	private double avg;

	public TempClass() {

	}

	
	
	public TempClass(String job, int count, int sum, double avg) {
		super();
		this.job = job;
		this.count = count;
		this.sum = sum;
		this.avg = avg;
	}



	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}
