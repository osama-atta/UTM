/**
 * 
 */
new gridjs.Grid({
  columns: ['Employee Id', 'Date', 'Comments'],
  server: {
    url: 'http://localhost:8080/UTM/timesheets/',
    then: data => data.map(timesheet => 
      [timesheet.employeeid, timesheet.date, timesheet.comments]
    )
  } 
}).render(document.getElementById("wrapper"));
