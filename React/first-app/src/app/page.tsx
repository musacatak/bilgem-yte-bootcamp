'use client'
import {useState} from 'react';

export default function Home() {
    const [count, setCount] = useState(0);

    function handleClick() {
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
