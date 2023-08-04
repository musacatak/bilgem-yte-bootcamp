'use client'

import {useRouter} from "next/navigation";

export default function Home() {


    const navigation = useRouter ();
    navigation.push('./pages/log-in');
  return (
    <main>
       <div>Dummy Home Page</div>
    </main>
  )
}
