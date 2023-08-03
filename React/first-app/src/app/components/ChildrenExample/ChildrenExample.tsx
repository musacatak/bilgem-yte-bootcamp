import "./ChildrenExample.css"
import {ReactNode} from "react";

interface propsType{
    label:string,
    children: ReactNode,
    notStrict?:string,
}
export default function ChildrenExample(props : propsType){

    return(
        <main>
            <h1>{props.label}</h1>
            <button className={"children-button"}>{props.children}</button>
        </main>
    );
}