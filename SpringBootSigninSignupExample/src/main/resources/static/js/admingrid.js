/**
 * Simple admin timesheet. I will add more when I get here the add functions etc.
 */
new gridjs.Grid({
  columns: ['Employee Id', 'Date', 'Comments', "Date Submitted", "Start Time", "End Time"],
  server: {
    url: 'http://localhost:8080/UTM/timesheets/',
    then: data => data.map(timesheet => 
      [timesheet.employeeid, timesheet.date, timesheet.comments, timesheet.datesubmitted, timesheet.starttime, timesheet.endtime]
    )
  } 
}).render(document.getElementById("wrapper"));
