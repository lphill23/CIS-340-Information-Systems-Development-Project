// Lucas Phillips, CIS 340 T/TH 1:30-2:45, SDLC Project - Deliverable 4: Implementation/Prototyping

public class Event {

	private String eventName;
	private String date;
	private String building;
	private String room;
	
	public Event (String eventName, String date, String building, String room) {
		this.eventName = eventName;
		this.date = date;
		this.building = building;
		this.room = room;
	}
	
	public String toString() {
		return eventName + " on " + date + " in " + building + ", " + room + ".";
	}
			
}
