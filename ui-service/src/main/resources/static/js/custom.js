function enableActiveMenuLink() {
    $('.nav li a[href="' + this.location.pathname + '"]').addClass('active');
}