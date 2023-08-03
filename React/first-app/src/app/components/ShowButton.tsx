import React, {Dispatch} from "react";
import "./ShowButton.css";

interface propsType {
    setShow: Dispatch<boolean>,
    show: boolean,

}

export default function ShowButton(props: propsType) {

    function handleClick() {
        if (props.show) {
            props.setShow(false);
        } else {
            props.setShow(true);

        }

    }

    return (
        <div>
            <button className={"show-button"} onClick={handleClick}>
                Show
            </button>

        </div>

    )

}