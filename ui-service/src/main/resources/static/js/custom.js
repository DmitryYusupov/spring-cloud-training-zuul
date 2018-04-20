function enableActiveMenuLink() {
    $('.nav li a[href="' + this.location.pathname + '"]').addClass('active');
}

function deleteCountry(countryId) {
    $.ajax({
        type: "DELETE",
        url: "/countries/" + countryId,
        success: function (msg) {
            location.reload();
        }
    })
};