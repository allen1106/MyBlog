$(document).ready(function () {
    converter = new showdown.Converter({tables: true, strikethrough: true});
    $('#edit-area').keypress(function () {
        text = $('#edit-area').val();
        console.log(text);
        html = converter.makeHtml(text);
        $('.show-container article').html(html);
    });
    $('#edit-area').trigger('keypress');
});