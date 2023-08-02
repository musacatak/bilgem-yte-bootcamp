import React, {Dispatch, SetStateAction, useState} from "react";
import "./ShowButton.css";

interface propsType {
    setShow: Dispatch<SetStateAction<any>>,
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
            <button className={"myButton"} onClick={handleClick}>
                Show
            </button>

        </div>

    )

}