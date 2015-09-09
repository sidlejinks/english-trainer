$(function(){
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $('.add-item-submit').on('click', function() {
        var originalItem = $('.item-original').val();
        var translationItem = $('.item-translation').val();

        var $resultArea = $('.result-area');
        $resultArea.empty();

        if (checkItemsAreValid(originalItem, translationItem)) {
            originalItem = analyzeCase(originalItem);
            translationItem = analyzeCase(translationItem);

            $.ajax({
                type: 'post',
                url: '/dictionary/add',
                data: JSON.stringify({
                    original: originalItem,
                    translation: translationItem
                }),
                contentType: 'application/json',
                success: function () {
                    $resultArea.text('Item has been successfully added!')
                },
                error: function () {
                    $resultArea.text('Something was wrong! item hasn\'t been added!');
                }
            });
        } else {
            $resultArea.text('Fields shouldn\'t be empty!');
        }
    });

    var checkItemsAreValid = function(original, translation) {
        return original && translation;
    };

    var analyzeCase = function(source) {
        var firstChar = source.charAt(0);
        return (firstChar == 'I') ? firstChar + source.slice(1).toLowerCase() : source.toLowerCase();
    };
});