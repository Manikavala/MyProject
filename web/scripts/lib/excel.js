function exportData(id) {
    var blob = new Blob([document.getElementById(id).innerHTML], {
        type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
    });
    var fileName = "Report.xls";
    saveAs(blob, fileName);
};