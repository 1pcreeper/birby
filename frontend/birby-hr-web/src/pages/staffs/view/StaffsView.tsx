import { Link, useLoaderData } from "react-router-dom";
import StaffsViewLoader from "../../../routes/loaders/StaffsViewLoader";
import Container from "../../../components/common/general/Container";
import TitleHeader from "../../../components/common/general/TitleHeader";

function StaffsView() {
    const loaderData: StaffsViewLoader = useLoaderData<StaffsViewLoader>();
    return (
        <>
            <Container>
                <TitleHeader title="Staff Management / Staff / View" />
                <div>
                    <div className="flex flex-wrap justify-between w-full mb-3 gap-x-2">
                        <Link to="/staffs">
                            <button type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                Back
                            </button>
                        </Link>
                        <Link to={`/staffs/edit/${loaderData.id}`}>
                            <button type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                Edit
                            </button>
                        </Link>
                    </div>
                    <div className="flex flex-wrap w-full justify-center">
                        <img src="https://fakeimg.pl/500x500/" className="size-60 mb-5" />
                        <div className="grow">
                            <div className="flex justify-between w-full flex-wrap">
                                <div className="p-4 text-2xl ms-5 grow">
                                    <div className="flex mb-2">
                                        <label htmlFor="form-tag">
                                            Tag :
                                        </label>
                                        <span>
                                            TAG
                                        </span>
                                    </div>
                                    <div className="flex mb-2">
                                        <label htmlFor="form-name">
                                            Name :
                                        </label>
                                        <span>
                                            NAME
                                        </span>
                                    </div>
                                    <div className="flex mb-2">
                                        <label htmlFor="form-id">
                                            ID :
                                        </label>
                                        <span>
                                            1234
                                        </span>
                                    </div>
                                    <div className="flex mb-2">
                                        <label htmlFor="form-email">
                                            Email :
                                        </label>
                                        <span>
                                            1234
                                        </span>
                                    </div>
                                    <div className="flex">
                                        <label htmlFor="form-gender">
                                            Gender :
                                        </label>
                                        <span>
                                            Male
                                        </span>
                                    </div>
                                </div>
                                <div className="text-2xl w-sm h-full rounded-2xl bg-amber-100 overflow-hidden mx-auto">
                                    <table className="w-full text-center">
                                        <thead>
                                            <tr className="border-b-2 border-amber-400 rounded-t-2xl bg-amber-300">
                                                <th className="p-2">
                                                    Roles
                                                </th>
                                                <th>
                                                    Depart.
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr className="p-3">
                                                <td title="XXXXX">
                                                    IT Admin
                                                </td>
                                                <td title="XXXXX">
                                                    IT
                                                </td>
                                            </tr>
                                            <tr className="p-3">
                                                <td title="XXXXX">
                                                    IT Admin
                                                </td>
                                                <td title="XXXXX">
                                                    IT
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </Container >
        </>
    );
}
export default StaffsView;