function showDownRun() {
    var text = document.getElementById('noteText').value,
        target = document.getElementById('mdText'),
        converter = new showdown.Converter(),
        html = converter.makeHtml(text);
    console.log(html);
    target.innerHTML = html;
}

layui.use('form', function(){
    var form = layui.form;
});

$('#sourceTA').change(function(){
    showDownRun();
});