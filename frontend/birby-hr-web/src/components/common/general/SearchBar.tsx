function SearchBar() {
    return (
        <>
            <div className="flex justify-around rounded-2xl border-2 mb-5 grow">
                <input type="text" className="w-full py-2" />
                <button className="text-white border-l-2 px-5 rounded-r-2xl dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Search
                </button>
            </div>
        </>
    );
}
export default SearchBar;