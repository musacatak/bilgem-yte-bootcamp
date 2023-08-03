import {useContext} from 'react'
import {ThemeContext} from "@/app/components/ThemeContext/ThemeContext";

export default function ContextExample(){
    const theme = useContext(ThemeContext);
    return <main>theme: {theme}</main>
}