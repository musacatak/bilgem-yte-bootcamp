'use client'
import React, {ReactNode} from 'react';
import "./catak.css"

interface props{
    children: ReactNode,
}
export default function Catak({ children } : props){
    return(
        <div>
            <header>
                <nav>
                    <a href="/">Home</a>
                    <a href="/catak/Cihangir">Cihangir Page</a>
                    <a href="/catak/Musa">Musa Page</a>
                </nav>
            </header>
            <main>{children}</main>
            <footer>
                {/* Your footer content can go here */}
                <p>© 2023 Next.js Example</p>
            </footer>
        </div>
    )

}