import { useLoaderData } from "react-router-dom";
import StaffsEditLoader from "../../../routes/loaders/StaffsEditLoader";

function StaffsEdit() {
    const loaderData: StaffsEditLoader = useLoaderData<StaffsEditLoader>();
    return (
        <>
        </>
    );
}
export default StaffsEdit;