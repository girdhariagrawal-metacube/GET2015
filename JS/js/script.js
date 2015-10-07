var rows;
function createInputTable() {
		rows = document.getElementById("rowsNumber").value;
		var inputTable = document.getElementById("inputTable");
		var string = "<tr><th>Name</th><th>Min</th><th>Max</th></tr>";
		for( count = 1; count <= rows; count++) {
			string +=  "<tr><td><input type='text' id='name"+count+"'></td>";
			string +=  "<td><input type='number' id='min"+count+"'></td>";
			string +=  "<td><input type='number' id='max"+count+"'></td></tr>";
		}
			string += "<tr><td colspan='3' align='center'><input type='button' value='Show Graphically' onClick='showTable()'> ";
			string += "<input type='reset'></td></tr>";
		inputTable.innerHTML = string;
}

function showTable() {	
	string = "";
	for(count = 1; count <= rows; count++) {
		name = document.getElementById("name"+count).value;
		min = document.getElementById("min"+count).value;
		max = document.getElementById("max"+count).value;
		
		if(min == "" || max == "") continue;
		if(min*1 > max*1) {
			alert("Row "+count+" column maximum have value less then minimum.");
			continue;
		}
		else if(min < 0 || max > 10 || min > 10 || max < 0) {
			alert("Row "+count+" !! Enter value within range..");
			continue;
		} else {
			string += "<tr><td id='name'>"+name+"</td>";
			for(count2 = 0; count2 <= 10; count2++) {
				if(count2 < min || count2 > max) {
					string += "<td class='noData'></td>";
				} else string += "<td class='data'></td>";
			}
			string += "</tr>"
		}
	}
	document.getElementById("tableData").innerHTML = string;
}