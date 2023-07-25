/*
	Thống kê doanh thu
	Version: 1.0
*/
$(document).ready(function() {
	// Click chọn tháng xem thống kê:
	$('.t-select-month').change(loadStatistical.bind(this));
    $('.t-select-top').change(loadTop.bind(this));
	
})


/*
	Load doanh thu theo tháng được chọn:
	Version: 1.0
*/
function loadStatistical(e) {
	// Lấy ra tháng được chọn:
	let month = $(e.target).val();
	console.log($(e.target).val());
    let top=sessionStorage.getItem("top");
    sessionStorage.setItem("monthProductSelling",month)
	
	// Gọi API lấy dữ liệu:
	$.ajax({
        type: "POST",
        url: `http://localhost:8088/admin/product-selling/${month}/${top}`,
        // async: false,
        data: JSON.stringify(month),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
			console.log(response);
        	window.location.reload();
        },
        error: function(reject) {
            // alert("Không thành công.");
            console.log(reject);
        }
    });	
	
}
function loadTop(e) {
    // Lấy ra tháng được chọn:
    let top = $(e.target).val();
    console.log($(e.target).val());
    sessionStorage.setItem("top",top)
    let month=sessionStorage.getItem("monthProductSelling")

    // Gọi API lấy dữ liệu:
    $.ajax({
        type: "POST",
        url: `http://localhost:8088/admin/product-selling/${month}/${top}`,
        // async: false,
        data: JSON.stringify(month),
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            window.location.reload();
        },
        error: function(reject) {
            // alert("Không thành công.");
            console.log(reject);
        }
    });

}

