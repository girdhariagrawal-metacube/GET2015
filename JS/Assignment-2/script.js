function createTable() {
	
		var tabledata = document.getElementById("tableData");
		var string = "";
		for(count = 1; count <= 5; count++) {
			name = document.getElementById("name"+count).value;
			min = document.getElementById("min"+count).value;
			max = document.getElementById("max"+count).value;
			if(min == "" || max == "") continue;
			if(min > max) {
				alert("Row "+count+" column maximum have value less then minimum.");
				continue;
			}
			else if(min < 0 || max > 9 || min > 9 || max < 0) {
				alert("Row "+count+" !! Enter value within range..");
				continue;
			} else {
				string += "<tr><td>"+name+"</td>";
				for(count2 = 0; count2 <= 9; count2++) {
					if(count2 < min || count2 > max) {
						string += "<td></td>";
					} else string += "<td class='data'></td>";
				}
				string += "</tr>"
			}
		}
		tableData.innerHTML = string;
	}
