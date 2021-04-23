/**
 * 
 */
new gridjs.Grid({

 	  columns: ['Employee Id', 'Comments', 'datesubmitted', "endtime", "starttime"],
		  server: {
		    url: 'http://localhost:8080/UTM/timesheets',
		    then: data => data.results.map(timesheet => 
		      [timesheet.employeeid, timesheet.comments, timesheet.datesubmitted timesheet.endtime, timesheet.starttime]
		    )
		  } 
	  
}).render(document.getElementById("wrapper"));