import { Form, NavigateFunction, useNavigate } from "react-router-dom";
import Container from "../../../components/common/general/Container";
import TitleHeader from "../../../components/common/general/TitleHeader";

function SickLeaveEdit() {
    const navigate: NavigateFunction = useNavigate();
    const handleOnClickCancel = (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        navigate(`/sick-leave`);
    }
    return (
        <>
            <Container>
                <TitleHeader title="Sick Leave / Edit" />
                <div className="pb-3 gap-x-2 flex">
                    <div className="flex flex-wrap justify-between w-full mb-3 gap-x-2">
                        <button onClick={handleOnClickCancel} type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Back
                        </button>
                        <button type="submit" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Submit
                        </button>
                    </div>
                </div>
                <Form method="POST" action="/sick-leave/edit">
                    <div>
                        <table className="w-full">
                            <thead className="sm:text-2xl text-lg">
                                <tr className="border-b-3">
                                    <th className="text-start ps-4">
                                        Leave Name
                                    </th>
                                    <th>
                                        Approvement
                                    </th>
                                    <th>
                                        Type
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr className="border-b-3 sm:text-2xl text-center">
                                    <td className="text-start ps-4">
                                        <input type="text" className="border-1 m-1" />
                                    </td>
                                    <td>
                                        <input type="text" className="border-1 m-1" />
                                    </td>
                                    <td>
                                        <input type="text" className="border-1 m-1" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </Form>
            </Container>
        </>
    );
}
export default SickLeaveEdit;