import {useEffect, useState} from "react";


export default function PSetInterval(){

    const[count,setCount] = useState(0);


    useEffect(() => {
        const intervalID = setInterval(() => {
            setCount(count +1)
        },1000)
        return () => clearInterval((intervalID))

    }, [count]);

    return(
        <div>
            Counter : {count}
        </div>
    )
}