/*
	Thống kê doanh thu
	Version: 1.0
*/
$(document).ready(function() {
	// Click chọn tháng xem thống kê:
	$('.t-select-month').change(loadStatistical.bind(this));
	$('.export-ingredient').click(exportStatistical.bind(this));

	
})


/*
	Load doanh thu theo tháng được chọn:
	Version: 1.0
*/
function loadStatistical(e) {
	// Lấy ra tháng được chọn:
	let month = $(e.target).val();
	console.log($(e.target).val());
    sessionStorage.setItem("monthIngredient",month);
	
	// Gọi API lấy dữ liệu:
	$.ajax({
        type: "POST",
        url: `http://localhost:8088/admin/ingredient/${month}`,
        // async: false,
        data: JSON.stringify(month),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
			console.log(response);
        	window.location.reload();
        },
        error: function(reject) {
            alert("Không thành công.");
            console.log(reject);
        }
    });	
	
}

function exportStatistical(e) {
    // Lấy ra tháng được chọn:
    let month = sessionStorage.getItem("monthIngredient");
    console.log(month);

    // Gọi API lấy dữ liệu:
    $.ajax({
        type: "GET",
        url: `http://localhost:8088/admin/ingredient/export/excel/${month}`,
        // async: false,
        data: JSON.stringify(month),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            // window.location.reload();
        },
        error: function(reject) {
            // alert("Không thành công.");
            console.log(reject);
        }
    });

}

