const btn = document.getElementById('btn');
btn.addEventListener('click', function handleClick() {

    fetch('https://jsonplaceholder.typicode.com/todos/1')
        .then(response => response.json())
        .then((json) => {
            console.log(json)
            alert(json.title)
            document.getElementById('data1').innerHTML = "completed: " + json.completed + "<br/>" + "id: " +
                json.id + "</br>" + "title: " + json.title + "<br/>" +
                "userId:" + json.userId
        });

});
