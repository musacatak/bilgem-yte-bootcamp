import {useEffect, useState} from "react";


export default function PSetInterval() {

    const [hour, setHour] = useState<number>(new Date().getHours());
    const [minute, setMinute] = useState<number>(new Date().getMinutes());
    const [second, setSecond] = useState<number>(new Date().getSeconds());

    useEffect(() => {
        const intervalID = setInterval(() => {
            if (second >= 60) {
                console.log("if1")
                setSecond(0);
                setMinute(minute + 1);
            }
            if (minute >= 60) {
                console.log("if2")
                setMinute(0);
                setHour(hour + 1);

            }
            if (hour >= 24) {
                console.log("if3")
                setHour(0);
            }

            setSecond(second + 1)

            console.log(hour + " " + minute + " " + second)
        }, 1000)
        return () => clearInterval((intervalID))

    }, [second, minute, hour]);

    return (
        <div className='card'>
            Time : {hour}:{minute}:{second}
        </div>
    )
}