const onWrite = () => {
    const title = document.querySelector('.title').value;
    const content = document.querySelector('.content').value;

    const obj = {title, content}

    axios.post('/day04/task/board', obj)
        .then(r => {console.log(r.data); onFindAll();})
        .catch(e => {console.error(e);})

}

const onFindAll = async() => {
    try{
        const r = await axios.get('/day04/task/board')
        const tbody = document.querySelector('tbody')
        let html = ''
            r.data.forEach(board => {
                html += `<tr>
                            <td>${board.title}</td>
                            <td>${board.content}</td>
                            <td>
                                <button onclick="onUpdate(${board.bno})">수정</button>
                                <button onclick="onDelete(${board.bno})">삭제</button>
                                <button onclick="onView(${board.bno})">상세조회</button>
                            </td>
                        </tr>`
            })
            tbody.innerHTML = html;
    }catch(e){console.log(e);}
}
onFindAll();


const onView = async(bno) => {
    try{
        const r = await axios.get(`/day04/task/board/view?bno=${bno}`)
        console.log(r);
        document.querySelector('.upTit').value = r.data.title
        document.querySelector('.upCont').value = r.data.content
    }catch(e){console.log(e);}

}




const onUpdate = async(bno) => {
    const title = prompt('새로운 제목')
    const content = prompt('새로운 내용')

    const obj = {bno, title, content}

    const r = await axios.put('/day04/task/board', obj)
    if(r.data == 1) {onFindAll();}
}



const onDelete = async(bno) => {
    const r = await axios.delete(`/day04/task/board?bno=${bno}`)
    if(r.data == 1) {onFindAll();}
}