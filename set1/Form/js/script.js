$(function () {
	$("#Startdate")
		.datepicker({
			autoclose: true,
			todayHighlight: true,
			todayBtn: "linked",
			title: " Startdate",
		})
		.datepicker("update", new Date());
});
$(function () {
	$("#enddate")
		.datepicker({
			autoclose: true,
			todayHighlight: true,
			todayBtn: "linked",
			title: " End date",
		})
		.datepicker("update", new Date());
});
