$(document).ready(function () {
    converter = new showdown.Converter({tables: true, strikethrough: true});
    $('#edit-area').keypress(function () {
        text = $('#edit-area').val();
        console.log(text);
        html = converter.makeHtml(text);
        $('.show-container article').html(html);
    });
    $('#edit-area').trigger('keypress');
    $('#post-btn').click(function () {
        title = $('#title').val();
        content = $('#edit-area').val();
        html = converter.makeHtml(content);
        summary = content.substring(0, 200);
        data = {
            'title': title,
            'summary': summary,
            'content': content
        }
        $.ajax({
            url: '/blog/edit/',
            type: 'post',
            data: data,
            success: function (resp) {
                console.log(resp);
            },
            error: function () {
            }
        });
        console.log(summary);
        console.log(html);
    });
});