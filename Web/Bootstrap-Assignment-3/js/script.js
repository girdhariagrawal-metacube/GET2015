function getAnswer() {
	var q1 = $("#question1").text();
	var q2 = $("#question2").text();
	var q3 = $("#question3").text();
	var q4 = $("#question4").text();
	var q5 = $("#question5").text();
	var a1 = $("#q1").val();
	var a2 = $("#q2").val();
	var a3 = $("#q3").val();
	var a4 = $("#q4").val();
	var a5 = $("#q5").val();
	$("#answer1").text(q1+" Answer is: "+a1);
	$("#answer2").text(q2+" Answer is: "+a2);
	$("#answer3").text(q3+" Answer is: "+a3);
	$("#answer4").text(q4+" Answer is: "+a4);
	$("#answer5").text(q5+" Answer is: "+a5);
}