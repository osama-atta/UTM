/**
 * 
 */
new gridjs.Grid({
  columns: ['Employee Id', 'Date', 'Comments'],
  server: {
    url: 'http://localhost:8080/UTM/timesheets/',
    then: data => data.map(movie => 
      [movie.employeeid, movie.date, movie.comments]
    )
  } 
}).render(document.getElementById("wrapper"));
