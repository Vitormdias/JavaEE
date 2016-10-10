package managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import entidades.Time;
import jpa.TimeJPA;

@ManagedBean
public class TimeManagedBean {
	private Time time = new Time();

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	public void salvar(){
	    TimeJPA jpa = new TimeJPA();
	    jpa.salvar(time);
	    time = new Time();
	    
	}
   
	public List <Time> getAllTimes(){
		TimeJPA jpa = new TimeJPA();
		return jpa.getAllTimes();
	}
}
