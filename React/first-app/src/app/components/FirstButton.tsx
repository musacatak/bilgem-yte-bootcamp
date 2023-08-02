import React, {Dispatch, SetStateAction, useState} from "react";
import "./FirstButton.css";

interface propsType {
    data: any,

}

export default function FirstButton(props: propsType) {
    const [count, setCount] = useState(0);

    function handleClick() {
        console.log(props.data)
        console.log('You clicked me!');
        setCount(count + 1)
    }

    return (
        <div>
            <p className={"counterText"}>{count}</p>
            <button className={"myButton"} onClick={handleClick}>
                Clicked {count} times
            </button>

        </div>

    )

}