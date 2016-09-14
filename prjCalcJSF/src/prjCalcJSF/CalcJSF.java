package prjCalcJSF;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalcJSF {
	private double n1 , n2 , resp;
	private String option;
	
	public String getOption() {
        return option;
	}
	 
	public void setOption(String option) {
	    this.option = option;
	}
	
	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public double getResp() {
		return resp;
	}

	public void setResp(double resp) {
		this.resp = resp;
	}
	
	public void op() {
		if(option.equals("+"))
			resp = n1 + n2;
		else if(option.equals("-"))
			resp = n1 - n2;
		else if(option.equals("*"))
			resp = n1 * n2;
		else
			resp = n1 / n2;
	}

}
