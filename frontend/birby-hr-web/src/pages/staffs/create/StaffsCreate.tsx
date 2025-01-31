import { Form, Link } from "react-router-dom";
import Container from "../../../components/common/general/Container";
import TitleHeader from "../../../components/common/general/TitleHeader";

function StaffsCreate() {
    return (
        <>
            <Container>
                <TitleHeader title="Staff Management / Staff / Create" />
                <Form method="post" action="/staffs/create">
                    <div className="flex flex-wrap w-full mb-3 gap-x-2 justify-between">
                        <Link to="/staffs">
                            <button type="submit" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                Back
                            </button>
                        </Link>
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
                                        <label htmlFor="form-tag">
                                            Tag :
                                        </label>
                                        <input type="text" id="form-tag" name="tag" value={""} className="grow border-1" placeholder="" />
                                    </div>
                                    <div className="flex mb-2">
                                        <label htmlFor="form-name">
                                            Name :
                                        </label>
                                        <input type="text" id="form-name" name="name" value={""} className="grow border-1" placeholder="Name" />
                                    </div>
                                    <div className="flex mb-2">
                                        <label htmlFor="form-email">
                                            Email :
                                        </label>
                                        <span className="ms-1">EMAIL</span>
                                    </div>
                                    <div>
                                        <label htmlFor="form-id">
                                            Avatar :
                                        </label>
                                        <input type="file" id="form-id" name="id" className="grow border-1 w-100" />
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