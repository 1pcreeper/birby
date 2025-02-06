import { Form, NavigateFunction, useNavigate } from "react-router-dom";
import Container from "../../../components/common/general/Container";
import TitleHeader from "../../../components/common/general/TitleHeader";


function StaffsCreate() {
    const navigate: NavigateFunction = useNavigate();
    const handleOnClickCancel = (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        navigate(`/staffs`);
    }
    return (
        <>
            <Container>
                <TitleHeader title="Staff Management / Staff / Create" />
                <Form method="post" action={`/staffs/create`}>
                    <div className="flex flex-wrap justify-between w-full mb-3 gap-x-2">
                        <button onClick={handleOnClickCancel} type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Back
                        </button>
                        <button type="submit" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Submit
                        </button>
                    </div>
                    <div className="flex flex-wrap w-full justify-center">
                        <img src="https://fakeimg.pl/500x500/" className="size-60 mb-5" />
                        <div className="grow">
                            <div className="flex justify-between w-full flex-wrap">
                                <div className="p-4 text-2xl ms-5 grow">
                                    <div className="flex mb-2">
                                        <label htmlFor="form-name">
                                            Name :
                                        </label>
                                        <input type="text" id="form-name" name="name" className="border-1" />
                                    </div>
                                    <div className="flex mb-2">
                                        <label htmlFor="form-display-name">
                                            Display Name :
                                        </label>
                                        <input type="text" id="form-display-name" name="display-name" className="border-1" />
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
                                        <label className="me-3">
                                            Gender :
                                        </label>
                                        <input type="radio" id="form-gender-male" name="gender" value={"male"} className="border-1" />
                                        <label className="me-3" htmlFor="form-gender-male">Male</label>
                                        <input type="radio" id="form-gender-female" name="gender" value={"female"} className="border-1" />
                                        <label htmlFor="form-gender-female">Female</label>
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
                                                <th>
                                                    <button type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                                        +
                                                    </button>
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
                                                <td>
                                                    <button type="button" className="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800">
                                                        X
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr className="p-3">
                                                <td title="XXXXX">
                                                    IT Admin
                                                </td>
                                                <td title="XXXXX">
                                                    IT
                                                </td>
                                                <td>
                                                    <button type="button" className="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800">
                                                        X
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </Form>
            </Container>
        </>
    )
}
export default StaffsCreate;