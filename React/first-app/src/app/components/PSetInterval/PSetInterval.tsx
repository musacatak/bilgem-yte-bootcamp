import {useEffect, useState} from "react";


export default function PSetInterval(){

    const[hour,setHour] = useState<number>(new Date().getHours());
    const[minute,setMinute] = useState<number>(new Date().getMinutes());
    const[second,setSecond] = useState<number>(new Date().getSeconds());
    const[timeS, setTimeS] = useState<number>(new Date().getSeconds());
    const[timeM, setTimeM] = useState<number>(new Date().getMinutes());
    const[timeH, setTimeH] = useState<number>(new Date().getHours());





    useEffect(() => {
        const intervalID = setInterval(() => {
            if(second >= 60){
                console.log("if1")
                setSecond(0);
                setMinute(minute + 1);
            }
            if(minute >= 60){
                console.log("if2")
                setMinute(0);
                setHour(hour + 1);

            }
            if(hour >= 24){
                console.log("if3")
                setHour(0);
            }

            setSecond(second + 1)
            setTimeS(new Date().getSeconds())
            setTimeM(new Date().getMinutes())
            setTimeH(new Date().getHours())

            console.log(hour + " " + minute + " " + second)
        },1000)
        return () => clearInterval((intervalID))

    }, [hour]);

    return(
        <div className='person-information'>
            Time : {hour}:{minute}:{second}
            <br/>
            Actual Time {timeH}:{timeM}:{timeS}
        </div>
    )
}