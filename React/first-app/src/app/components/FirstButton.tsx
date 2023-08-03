import React, {useState} from "react";
import "./FirstButton.css";

export default function FirstButton() {
    const [count, setCount] = useState(0);

    function handleClick() {
        setCount(count + 1)
    }

    return (
        <div>
            <p className={"counter-text"}>{count}</p>
            <button className={"counter-button"} onClick={handleClick}>
                Clicked {count} times
            </button>

        </div>

    )

}