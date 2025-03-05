import { Link } from "react-router-dom";
import Container from "../../components/common/general/Container";
import TitleHeader from "../../components/common/general/TitleHeader";

function SickLeave() {
    return (
        <>
            <Container>
                <TitleHeader title="Sick Leave" />
                <div className="pb-3 gap-x-2 flex">
                    <Link to="/dashboard">
                        <button className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Back
                        </button>
                    </Link>
                    <Link to="/sick-leave/edit">
                        <button className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Edit
                        </button>
                    </Link>
                    <Link to="/sick-leave/create">
                        <button className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Create
                        </button>
                    </Link>
                </div>
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
                                <td className="text-start ps-4">Annual Leave</td>
                                <td>Full Time Only</td>
                                <td>Per Day</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </Container>
        </>
    );
}
export default SickLeave;