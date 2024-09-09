import FoodTruck from "@/types/FoodTruck";

export default function MarkMap({data}: Readonly<{data: any[]}>) {
    return (
        <div id="mapArea">
            <div style={{minHeight:"400px", backgroundColor:"rgb(41 111 147)", color:"white", "display":"flex", "justifyContent":"center"}}>
                <table border={1}  style={{width:"100%", height:"fit-content"}}>
                    <tbody>
                        <tr><td width={47}>Index</td><td width={80}>Applicant</td><td width={50}>Type</td><td width={80}>Address</td><td>Location Description</td><td width={100}>Food items</td></tr>
                        {data.map((item, index) => {
                            let rowData = item as FoodTruck;
                            return (
                                <tr key={index+1}>
                                    <td>{index}</td><td>{rowData.applicant}</td><td>{rowData.type}</td><td>{rowData.address}</td><td>{rowData.locationDescription}</td><td>
                                        {rowData.foodItems.length?(
                                                rowData.foodItems.map((item, index)=>{
                                                    return (<div>{item}</div>)
                                                })
                                        ):(<div></div>)
                                        }
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
        </div>
    );

}