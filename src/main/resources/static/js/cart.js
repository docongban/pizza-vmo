/**
 * Xử lý giỏ hàng
 * Version: 1.0
 */
 
$(document).ready(function() {
	// Xử lý nghiệp vụ khi ấn thanh toán:
	$('.product-btn__pay').click(handlePayement.bind(this));
	
})


/*
	Hàm xử lý thanh toán
	Version: 1.0
*/
function handlePayement(e) {
	// 1. Lấy ra phương thức thanh toán:
	let payMethod = $('input[name="paymethod"]:checked').attr('id');
	
	// 2. Lấy ra số tiền thành toán:
	let amount = Number($('.t-total-price').text().replace(',','').replace(' ','').replace('đ',''));
	
	// Kiếm tra phương thức thanh toán:
	if(payMethod == 'pay-offline') {
		window.location.href = `http://localhost:8088/cart/check-out`;
	} else {
		window.location.href = `http://localhost:8088/cart/payment/${amount}`;
	}
	
}
