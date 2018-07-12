package com.calebo.rev.project01.pojos;

public class ReimbursementForm
{
	private String eventType;
	private String eventLocation;
	private double cost;
	private String gradingFormat;
	private String startTime;
	private String endTime;
	private String startDate;
	private String endDate;
	private int missedDays;
	private String description;
	private String justification;
	private double estimatedCost;
	private boolean hAppr;
	private boolean sAppr;
	private boolean bAppr;
	
	public ReimbursementForm() {
		super();
		eventType = "";
		eventLocation = "";
		cost = 0.0;
		gradingFormat = "";
		startTime = "";
		endTime = "";
		startDate = "";
		endDate = "";
		missedDays = 0;
		description = "";
		justification = "";
		estimatedCost = 0.0;
	}
	
	public ReimbursementForm(String eventType, String eventLocation, double cost, String gradingFormat,
			String startTime, String endTime, String startDate, String endDate, int missedDays, String description,
			String justification, double estimatedCost) {
		super();
		this.eventType = eventType;
		this.eventLocation = eventLocation;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.missedDays = missedDays;
		this.description = description;
		this.justification = justification;
		this.estimatedCost = estimatedCost;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getMissedDays() {
		return missedDays;
	}
	public void setMissedDays(int missedDays) {
		this.missedDays = missedDays;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	
	public boolean ishAppr() {
		return hAppr;
	}

	public void sethAppr(boolean hAppr) {
		this.hAppr = hAppr;
	}

	public boolean issAppr() {
		return sAppr;
	}

	public void setsAppr(boolean sAppr) {
		this.sAppr = sAppr;
	}

	public boolean isbAppr() {
		return bAppr;
	}

	public void setbAppr(boolean bAppr) {
		this.bAppr = bAppr;
	}

	@Override
	public String toString() {
		return "ReimbursementForm [eventType=" + eventType + ", eventLocation=" + eventLocation + ", cost=" + cost
				+ ", gradingFormat=" + gradingFormat + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", missedDays=" + missedDays + ", description="
				+ description + ", justification=" + justification + ", estimatedCost=" + estimatedCost + ", hAppr="
				+ hAppr + ", sAppr=" + sAppr + ", bAppr=" + bAppr + "]";
	}
	
	public String sqlString()
	{
		return  "'"+ eventType + "','" + eventLocation + "','" + cost
				+ "','" + gradingFormat + "','" + startTime + "','" + endTime
				+ "','" + startDate + "','" + endDate + "','" + missedDays + "','"
				+ description + "','" + justification + "','" + estimatedCost + "','"
				+ hAppr + "','" + sAppr + "','" + bAppr + "'";
	}
}
