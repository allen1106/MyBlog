(function($) {
    $.fn.extend({
        "clickNavTab": function() {
            $(this).addClass('nav-item-checked');
            $(this).siblings().removeClass('nav-item-checked');
        }
    });
    $('.nav-item').bind('click', $(this).clickNavTab);
})(jQuery);