import Image from "next/image";
import styles from "./SearchArea.module.css";
import { useState } from "react";

export default function SearchArea({search}:{search:Function}) {
    let [cityInput, setCityInput] = useState("");
    let [foodNameInput, setFoodNameInput] = useState("");
    return (
    <div className={styles.search_area}>
        <span>
          <Image
            src="https://datasf.org/assets/img/city_seal_white.png"
            alt="logo"
            width={48}
            height={48}
            priority
          />
        </span>
        <input type="text" id="city" placeholder="City name to search" value={cityInput} onChange= {(e)=>setCityInput(e.target.value)} style={{height:"35px"}}></input> <span>City</span>
        <input type="text" id="foodName" placeholder="Food name to search" value={foodNameInput} onChange= {(e)=>setFoodNameInput(e.target.value)} style={{height:"35px"}}></input> <span>Food Name</span>
        <span className={styles.span}>
            <a
            className={styles.primary}
            style={{backgroundColor: "white", color: "black", padding: "10px 20px", borderRadius: "5px", cursor: "pointer"}}
            target="_blank"
            rel="noopener noreferrer"
            onClick={(e) => {
              e.stopPropagation;
              e.preventDefault;
              setCityInput((document.getElementById("city") as HTMLInputElement)?.value);
              setFoodNameInput((document.getElementById("foodName") as HTMLInputElement)?.value);
              search(cityInput, foodNameInput);
            }}
            >
            Search
            </a>
        </span>
      </div>
    );

}